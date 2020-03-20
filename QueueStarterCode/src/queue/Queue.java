package queue;

import java.util.*;

import javax.swing.JTextField;

public class Queue extends Thread {
	private Vector<Client> queue = new Vector<Client>();
	private int queueID;
	private static int servingTime;

	public Queue(int ID)
	{
		this.queueID=ID;
	}

	// overrided method of the Thread class
	public void run() 
	{
		
		//try - catch structure to avoid interruption errors
		try 
		{
			while ( true ) // the condition is always true because you want to delete as fast as you are allowed
			{
				if (queue.size() != 0) {
					Client first = queue.elementAt(0);
					servingTime = first.getServiceTime();

					// sleep waits for the indicated amount of seconds before going to the next line
					sleep( servingTime * 1000 );

					// deleteClient deletes according to FIFO behaviour
					deleteClient();
				}
			}
			
		}
		catch (InterruptedException e) 
		{
			System.out.println("Intrerupere");
		}
	}
	
	public synchronized void addClient(Client client) throws InterruptedException 
	{
		queue.addElement(client);
		System.out.println("Client (" + client.getClientID() + ", "  + client.getArrivalTime() + ", "  + client.getServiceTime() + ")  arrived at Queue " + queueID+"\n");
		
		notifyAll(); 
	}

	public synchronized void deleteClient() throws InterruptedException 
	{
		while (queue.size() == 0) // verifies if the queue is empty
		{
			wait(); // if it is empty it waits for the notify
		}
		Client client = (Client) queue.elementAt(0); //saves the removed element in order to print it later
		queue.removeElementAt(0); // removes the beginning of the vector

		System.out.println("Client (" + client.getClientID() + ", "  + client.getArrivalTime() + ", "  + client.getServiceTime() + ") left Queue " + queueID+"\n");
		
		// wakes all threads in the waiting set
		notifyAll();
	}

	public synchronized long sizeQueue() throws InterruptedException
	{
		notifyAll();
		return queue.size();
	}
}
