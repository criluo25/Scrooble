package bca;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class PlayerHandler implements Runnable {
    private Socket socket;
    private GameServer server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private List<Letter> hand;

    public PlayerHandler(Socket socket, GameServer server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
        this.hand = server.getAlphabet().get(7); // Each player gets 7 letters initially
    }

    @Override
    public void run() {
        try {
            sendInitialState();
            while (true) {
                Object obj = in.readObject();
                if (obj instanceof GameMove) {
                    handleGameMove((GameMove) obj);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendInitialState() throws IOException {
        out.writeObject(hand);
        out.writeObject(server.getBoard());
    }

    public void sendGameState() throws IOException {
        out.writeObject(server.getBoard());
    }

    private synchronized void handleGameMove(GameMove move) throws IOException {
        Board board = server.getBoard();
        if (board.placeTile(move.getRow(), move.getCol(), move.getLetter())) {
            server.broadcastGameState();
        }
    }
}
