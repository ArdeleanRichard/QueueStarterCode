package queue;

public class Generate extends Thread {
	private Queue[] queue;
	private static int clientID = 0;
	private int nrClients;
	private int nrQueues;
	private int simulationTime;
	private int minimumArrivalTime;
	private int maximumArrivalTime;
	private int minimumServiceTime;
	private int maximumServiceTime;


	//class constructor
	public Generate(int nrQueues, Queue[] queue, int nrClients,  int simulationTime, int minimumArrivingTime, int maximumArrivingTime, int minimumServiceTime, int maximumServiceTime) {
		this.nrClients = nrClients;
		this.nrQueues = nrQueues;
		this.simulationTime = simulationTime;
		this.minimumArrivalTime = minimumArrivingTime;
		this.maximumArrivalTime = maximumArrivingTime;
		this.minimumServiceTime = minimumServiceTime;
		this.maximumServiceTime = maximumServiceTime;

		this.queue = new Queue[nrQueues];
		for(int i = 0; i < nrQueues; i++)
		{
			this.queue[i] =queue[i] ;
		}
	}

	//function that returns the index of the queue with the smallest number of elements
	private int minQueue() 
	{
		int index = 0;
		try
		{
			long min = queue[0].sizeQueue();
			for (int i = 1; i < this.nrQueues; i++)
			{
				long size = queue[i].sizeQueue();
				if (size < min) 
				{
					min = size;
					index = i;
				}
			}
		} 
		catch (InterruptedException e) 
		{
			System.out.println(e.toString());
		}
		return index;
	}

	public void run() 
	{
		clientID = 0;

		try 
		{
			double time= 0;
			while ((int)time < this.simulationTime && clientID < nrClients)
			{
				System.out.println(minQueue());
				int arrivalTime = (int) (Math.random() * (this.maximumArrivalTime - this.minimumArrivalTime) + this.minimumArrivalTime);
				int serviceTime = (int) (Math.random() * (this.maximumServiceTime - this.minimumServiceTime) + this.minimumServiceTime);

				int q = minQueue();
				Client c = new Client(++clientID, arrivalTime, serviceTime);
				queue[q].addClient(c);
			}
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Intrerupere");
		}
	}
}
