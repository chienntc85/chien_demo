$(document).ready(function() {
	
	var tags_history =[];
	var tags_search =[];
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/tag-limit"
	}).then(function(data) {
		console.log(data);
		tags_history=data;
		$("#search").catcomplete({
			delay: 0,
			source: tags_history,
			 minLength: 0
		}).focus(function() {
		      $(this).catcomplete('search', $(this).val());
	    });
	});
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/tagsearchs"
	}).then(function(data) {
		tags_search = data;
	});
	$('#search').on('input', function() {
		  // Do this when value changes
		if($(this).val().length == 1 )
		{
			$("#search").catcomplete('option', 'source', tags_search);
				
		}else if($(this).val().length < 1 ){
			$( "#search" ).catcomplete('option', 'source', tags_history);
		}
	});
	
	/*$("input.gtm_search_bar").change(function(){
		if($(this).val().length == 1 ){
			alert("123");
			$.ajax({
				type : "GET",
				url : "/HiBook_KLTN19/api/v1/tagsearchs"
			}).then(function(data) {
				tags=data;
				$("#search").catcomplete({
					delay: 0,
					source: tags,
					minLength: 1
				});
			});
		}
	});*/
	
	$.widget( "custom.catcomplete", $.ui.autocomplete, {
	      _create: function() {
	        this._super();
	        this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
	      },
	      _renderMenu: function( ul, items ) {
	        var that = this,
	          currentCategory = "";
	        $.each( items, function( index, item ) {
	          var li;
	          if ( item.category != currentCategory ) {
	            ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
	            currentCategory = item.category;
	          }
	          li = that._renderItemData( ul, item );
	          if ( item.category ) {
	            li.attr( "aria-nameTag", item.category + " : " + item.value );

	          }
	        });
	      }
	    });

});