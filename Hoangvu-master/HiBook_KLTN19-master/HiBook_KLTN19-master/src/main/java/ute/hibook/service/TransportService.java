package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.TransportDTO;


public interface TransportService {

	public void addTransport(TransportDTO transportDTO);
	public void updateTransport(TransportDTO transportDTO);
	public void deleteTransport(int idTransport);
	public TransportDTO getTransportById(int idTransport);
	public List<TransportDTO> getAllTransport();
}
