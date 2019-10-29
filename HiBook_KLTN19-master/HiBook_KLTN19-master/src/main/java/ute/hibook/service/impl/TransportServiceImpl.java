package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.TransportDaoImpl;
import ute.hibook.dto.TransportDTO;
import ute.hibook.entity.Transport;
import ute.hibook.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService{

	@Autowired
	TransportDaoImpl transportDao;
	
	public void addTransport(TransportDTO transportDTO) {
		Transport transport= new Transport();
		transport.setNameTransport(transportDTO.getNameTransport());
		transport.setDescribes(transportDTO.getDescribes());
		transport.setFee(transportDTO.getFee());
		
		transportDao.addTransport(transport);		
		System.out.println("add Transport successful!");
	}

	public void updateTransport(TransportDTO transportDTO) {
		Transport transport= transportDao.getTransportById(transportDTO.getIdTransport());
		if(transport!=null) {
			transport.setNameTransport(transportDTO.getNameTransport());
			transport.setDescribes(transportDTO.getDescribes());
			transport.setFee(transportDTO.getFee());
			
			transportDao.updateTransport(transport);
			System.out.println("update Transport successful!");
		}
	}

	public void deleteTransport(int idTransport) {
		Transport transport= transportDao.getTransportById(idTransport);
		if(transport!=null) {
			transportDao.deleteTransport(idTransport);
			System.out.println("delete Transport successful!");
		}
	}

	public TransportDTO getTransportById(int idTransport) {
		Transport transport= transportDao.getTransportById(idTransport);
		
		TransportDTO transportDTO= new TransportDTO();
		transportDTO.setIdTransport(transport.getIdTransport());
		transportDTO.setNameTransport(transport.getNameTransport());
		transportDTO.setDescribes(transport.getDescribes());
		transportDTO.setFee(transport.getFee());
		//System.out.println(transport.getBills().get(0).getNameReceiver());
		
		return transportDTO;
	}

	public List<TransportDTO> getAllTransport() {
		List<Transport> lstTransport= transportDao.getAllTransport();
		
		List<TransportDTO> lstTransportDTO= new ArrayList<TransportDTO>();
		for (Transport transport : lstTransport) {
			
			TransportDTO transportDTO= new TransportDTO();
			transportDTO.setIdTransport(transport.getIdTransport());
			transportDTO.setNameTransport(transport.getNameTransport());
			transportDTO.setDescribes(transport.getDescribes());
			transportDTO.setFee(transport.getFee());
			
			lstTransportDTO.add(transportDTO);
		}
		return lstTransportDTO;
	}

}
