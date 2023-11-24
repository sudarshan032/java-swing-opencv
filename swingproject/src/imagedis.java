import org.opencv.core.*;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;

public class imagedis extends JFrame {
    private final JLabel cameraLabel;
    private final CascadeClassifier faceCascade;
    private final VideoCapture capture;

    public imagedis() {
        setTitle("Face Detection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        cameraLabel = new JLabel();
        add(cameraLabel, BorderLayout.CENTER);

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        faceCascade = new CascadeClassifier("C:/Users/siddh/opencv/sources/data/haarcascades/haarcascade_frontalface_default.xml");
        capture = new VideoCapture(0);

        Timer timer = new Timer(33, e -> {
            Mat frame = new Mat();
            capture.read(frame);

            MatOfRect faces = new MatOfRect();
            faceCascade.detectMultiScale(frame, faces);

            for (Rect rect : faces.toArray()) {
                Imgproc.rectangle(frame, new org.opencv.core.Point(rect.x, rect.y), new org.opencv.core.Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 3);
            }

            Mat resizedFrame = new Mat();
            Imgproc.resize(frame, resizedFrame, new Size(800, 600));

            BufferedImage image = matToBufferedImage(resizedFrame);
            cameraLabel.setIcon(new ImageIcon(image));
        });

        timer.start();
    }

    private BufferedImage matToBufferedImage(Mat mat) {
        int width = mat.width();
        int height = mat.height();
        int channels = mat.channels();
        byte[] sourcePixels = new byte[width * height * channels];
        mat.get(0, 0, sourcePixels);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);

        return image;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            imagedis app = new imagedis();
            app.setVisible(true);
        });
    }
}
