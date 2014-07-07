package model.externalcomm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.cedarsoftware.util.io.JsonReader;

import model.tasks.TaskModel;
import model.tasks.basictasks.IExecuteTask;

public class ClientTask implements Runnable {
	
    private final Socket clientSocket;
    
    private ObjectInputStream inputStream;
    
    private TaskModel taskModel;
    
    public ClientTask(Socket clientSocket, TaskModel taskModel) {
        this.clientSocket = clientSocket;
        this.taskModel = taskModel;
    }

    @Override
    public void run() {
        System.out.println("Got a client !");

        // Do whatever required to process the client's request
        try {
        	inputStream = new ObjectInputStream(clientSocket.getInputStream());
		    while (true){
		    	JsonReader jr = new JsonReader(inputStream);
		    	IExecuteTask task = (IExecuteTask) jr.readObject();
		    	taskModel.appendTaskToQueue(task);
		    }
		    
		} catch (Exception e1) {
			e1.printStackTrace();
		}

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
