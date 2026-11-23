package data;
import entity.User;
import java.io.FileNotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import java.util.concurrent.ExecutionException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import use_case.create_prediction.CreatePredictionDataAccessInterface;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import java.util.List;
import java.io.*;
/**
 * DAO for user data implemented using a File to persist the data.
 * this firestore genuinely testing my patience bro
 */
public class PredictionDataAccessObject implements CreatePredictionDataAccessInterface {
    
    private final FileInputStream serviceAccount;
    private final FirebaseOptions options;
    private final Firestore database;

    public PredictionDataAccessObject() throws FileNotFoundException, IOException {
        serviceAccount = new FileInputStream("src/firebasekey.json");
        options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(this.serviceAccount))
            .build();
        FirebaseApp.initializeApp(options);
        database = FirestoreClient.getFirestore();
    }

    public boolean existsByTitle() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = database.collection("predictions").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    }
    
}
