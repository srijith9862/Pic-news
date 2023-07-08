package meerkat.picnews.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\'\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lmeerkat/picnews/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "newsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/google/firebase/firestore/DocumentSnapshot;", "Lkotlin/collections/ArrayList;", "getNewsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "snapShotArray", "getSnapShotArray", "()Ljava/util/ArrayList;", "tags_array", "", "", "getTags_array", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fetchNewsArticle", "", "Companion", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private com.google.firebase.firestore.FirebaseFirestore db;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] tags_array = {"technology", "sports", "entertainment"};
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot>> newsLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot> snapShotArray = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "MainViewModel";
    public static final meerkat.picnews.ui.main.MainViewModel.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getTags_array() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot>> getNewsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot> getSnapShotArray() {
        return null;
    }
    
    public final void fetchNewsArticle() {
    }
    
    public MainViewModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lmeerkat/picnews/ui/main/MainViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}