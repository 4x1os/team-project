package data;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import use_case.create_prediction.CreatePredictionDataAccessInterface;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import java.io.*;

import entity.Prediction;

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

    public boolean existsByTitle(String title) {
        if (title == null || title.isBlank()){ throw new IllegalArgumentException("Title cannot be empty");}
        DocumentReference docRef = database.collection("predictions").document(title);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        try{
            DocumentSnapshot document = future.get();
            return document.exists();
        } catch (Exception e){
            throw new RuntimeException("Database request failed: ", e);
        }
    }
    
    public void save(Prediction prediction){
        database.collection("predictions")
            .add(prediction);
    }
    
}
