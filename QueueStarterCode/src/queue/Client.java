package queue;

public class Client {
	private int clientID;
	private int arrivalTime;
	private int serviceTime;

	public Client(int clientID)
	{
		this.clientID = clientID;
	}

	public Client(int clientID, int arrivalTime, int serviceTime) {
		this.clientID = clientID;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
}
