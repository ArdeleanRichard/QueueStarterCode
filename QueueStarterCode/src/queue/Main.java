package queue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{
	public static void main(String[] args)
	{
		// Read from file (write code)
		// numbers taken from assignment doc
		int nrClients = 4;
		int nrQueues = 2;
		int simulationTime = 60;
		int minimumArrivingTime = 2;
		int maximumArrivingTime = 7;
		int minimumServiceTime = 2;
		int maximumServiceTime = 4;

		// End read from file

		Queue[] queues = new Queue[nrQueues];

		for(int i=0; i<nrQueues; i++)
		{
			queues[i] = new Queue(i);
			queues[i].start();
		}

		Generate g = new Generate(nrQueues, queues, nrClients, simulationTime, minimumArrivingTime, maximumArrivingTime, minimumServiceTime, maximumServiceTime);
		g.start();

	}
}