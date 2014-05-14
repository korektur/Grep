package ru.ifmo.ctddev.Akhundov.task8;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * @author Руслан
 *         Server for completing tasks recieved from Client and the sending the result back threw UDP.
 * @see java.lang.Runnable
 * @see ru.ifmo.ctddev.Akhundov.task8.HelloUDPClient
 */
public class HelloUDPServer implements Runnable {

    private final int id;
    private static final int MAX_BUFF_SIZE = 65535;
    private final DatagramSocket socket;
    private static final int NUM_OF_THREADS = 10;

    /**
     * Starts <tt>HelloUDPServer</tt>.
     * <p>
     * <tt>args[0]</tt> - port which needs to be listen to receive tasks.
     *
     * @param args parameters for <tt>HelloUDPServer</tt>
     */
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            DatagramSocket socket = new DatagramSocket(port);
            for (int i = 0; i < NUM_OF_THREADS; ++i) {
                Thread newThread = new Thread(new HelloUDPServer(socket, i));
                newThread.start();
            }
        } catch (SocketException e) {
            System.out.println("cannot open socket on server");
        }
    }

    /**
     * Creates new instance of <tt>HelloUDPServer</tt>
     *
     * @param socket socket which is needed to be listened to receive tasks
     * @param id     server id
     * @see java.net.DatagramSocket
     */
    public HelloUDPServer(DatagramSocket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    /**
     * While current thread isn't interrupted waits for the new task. Then sends the result of the task.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            DatagramPacket receivingPacket = new DatagramPacket(new byte[MAX_BUFF_SIZE], MAX_BUFF_SIZE);
            try {
                socket.receive(receivingPacket);
                String message = new String(receivingPacket.getData(), 0, receivingPacket.getLength());
                message = "Hello, " + message;
                byte[] toSend = message.getBytes();
                DatagramPacket packet = new DatagramPacket(toSend,
                        toSend.length, receivingPacket.getAddress(), receivingPacket.getPort());
                socket.send(packet);
            } catch (IOException e) {
                System.out.println("IOException in server thread " + (id + 1) + ". Interrupting.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
