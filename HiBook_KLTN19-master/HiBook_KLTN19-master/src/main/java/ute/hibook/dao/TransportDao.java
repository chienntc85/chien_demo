package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Transport;

public interface TransportDao {

	public void addTransport(Transport transport);
	public void updateTransport(Transport transport);
	public void deleteTransport(int idTransport);
	public Transport getTransportById(int idTransport);
	public List<Transport> getAllTransport();
}
