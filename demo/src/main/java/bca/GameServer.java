package bca;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private ServerSocket serverSocket;
    private List<PlayerHandler> players;
    private Alphabet alphabet;
    private Board board;

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        players = new ArrayList<>();
        alphabet = new Alphabet();
        board = new Board();
    }

    public void start() throws IOException {
        System.out.println("Game server started on port 54323.");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());
            PlayerHandler playerHandler = new PlayerHandler(socket, this);
            players.add(playerHandler);
            new Thread(playerHandler).start();
        }
    }

    public synchronized Alphabet getAlphabet() {
        return alphabet;
    }

    public synchronized Board getBoard() {
        return board;
    }

    public synchronized void broadcastGameState() throws IOException {
        for (PlayerHandler player : players) {
            player.sendGameState();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer(54323);
        server.start();
    }
}