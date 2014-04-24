package ru.ifmo.ctddev.Akhundov.task8;

import java.io.IOException;
import java.net.*;


/**
 * @author Руслан
 *         Client which generates tasks for Server. Sends it by UDP, and then recieves the result.
 * @see ru.ifmo.ctddev.Akhundov.task8.HelloUDPServer
 * @see java.lang.Runnable
 */
public class HelloUDPClient implements Runnable {

    private final int id;
    private final DatagramSocket socket;
    private final InetAddress address;
    private final int port;
    private final String prefix;
    private static final int NUM_OF_THREADS = 10;
    private static final int MAX_BUFF_SIZE = 65535;


    /**
     * Starts Client.
     * <p>
     * <tt>args[0]</tt> - name or ip address of server.
     * <p>
     * <tt>args[1]</tt> - server port.
     * <p>
     * <tt>args[2]</tt> - prefix of the task.
     *
     * @param args parameters for Client
     */
    public static void main(String[] args) {
        String name = args[0];
        int port = Integer.parseInt(args[1]);
        String prefix = args[2];
        InetAddress inetAddress;
        try {
            //System.out.println(Inet4Address.getLocalHost().getHostAddress());
            inetAddress = InetAddress.getByName(name);
        } catch (UnknownHostException e) {
            String[] parts = name.split("\\.");
            byte[] address = new byte[parts.length];
            for (int i = 0; i < parts.length; ++i) {
                address[i] = Byte.parseByte(parts[i]);
            }
            try {
                inetAddress = InetAddress.getByAddress(address);
            } catch (UnknownHostException ex) {
                System.out.println("unknown host");
                return;
            }
        }

        for (int i = 0; i < NUM_OF_THREADS; ++i) {
            try {
                Thread newThread = new Thread(new HelloUDPClient(inetAddress, port, prefix, i));
                newThread.start();
            } catch (SocketException e) {
                System.out.println("an error occurred during client creation");
                return;
            }
        }
    }

    /**
     * Creates new instance of <tt>HelloUDPClient</tt>
     *
     * @param address <tt>InetAddress</tt> of server
     * @param port    server port
     * @param prefix  prefix for the task
     * @param id      clients id
     * @throws SocketException when cannot create new <tt>DatagramSocket</tt>
     * @see java.net.DatagramSocket
     */
    public HelloUDPClient(InetAddress address, int port, String prefix, int id) throws SocketException {
        socket = new DatagramSocket();
        this.address = address;
        this.port = port;
        this.prefix = prefix;
        this.id = id;
    }


    /**
     * while current thread  isn't interrupted creates new Tasks from given <tt>prefix</tt>
     * and sends them to server. Then it's waiting for result and writing result
     * @see java.lang.Runnable
     */
    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted()) {
            String request = prefix + "_" + (id + 1) + "_" + (num++);
            byte[] bytes = request.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
            ++num;
            try {
                socket.send(datagramPacket);
                DatagramPacket receivingPacket = new DatagramPacket(new byte[MAX_BUFF_SIZE], MAX_BUFF_SIZE);
                socket.receive(receivingPacket);
                byte[] receivedBytes = receivingPacket.getData();
                int receivedMessageLength = receivingPacket.getLength();
                String message = new String(receivedBytes, 0, receivedMessageLength);
                System.out.println(message);
            } catch (IOException e) {
                System.out.println("IOException at client thread " + (id + 1) + ". Interrupting.");
                Thread.currentThread().interrupt();
            }
        }
    }

}
