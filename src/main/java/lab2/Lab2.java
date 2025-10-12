/*
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AvatarViewer {

    public static void main(String[] args) {
        try {
            InputStream avatarStream = getRandomAvatarStream();
            showAvatar(avatarStream);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getRandomAvatarStream() throws IOException, InterruptedException {
        // Pick a random style
        String[] styles = {
                "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral",
                "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons",
                "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps",
                "personas", "pixel-art", "pixel-art-neutral"
        };
        String style = styles[(int) (Math.random() * styles.length)];

        // Generate a random seed
        int seed = (int) (Math.random() * 10000);

        // Build the API URL
        URI uri = URI.create(String.format("https://api.dicebear.com/9.x/%s/png?seed=%d", style, seed));

        // Send HTTP request
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        return response.body();
    }

    private static void showAvatar(InputStream imageStream) {
        JFrame frame = new JFrame("Random Avatar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.getContentPane().setBackground(Color.BLACK);

        try {
            Image image = ImageIO.read(imageStream);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            frame.add(imageLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}
*/
