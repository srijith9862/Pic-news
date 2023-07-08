package meerkat.picnews.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lmeerkat/picnews/ui/main/MainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "viewModel", "Lmeerkat/picnews/ui/main/MainViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "NewsAdapter", "app_debug"})
public final class MainFragment extends androidx.fragment.app.Fragment {
    private meerkat.picnews.ui.main.MainViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "e";
    public static final meerkat.picnews.ui.main.MainFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public MainFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lmeerkat/picnews/ui/main/MainFragment$NewsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmeerkat/picnews/ui/main/MainFragment$NewsAdapter$ViewHolder;", "cxt", "Landroid/content/Context;", "itemsArray", "Ljava/util/ArrayList;", "Lcom/google/firebase/firestore/DocumentSnapshot;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemsArray", "()Ljava/util/ArrayList;", "setItemsArray", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public static final class NewsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<meerkat.picnews.ui.main.MainFragment.NewsAdapter.ViewHolder> {
        @org.jetbrains.annotations.Nullable()
        private android.content.Context context;
        @org.jetbrains.annotations.Nullable()
        private java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot> itemsArray;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String TAG = "NewsAdapter";
        
        @org.jetbrains.annotations.Nullable()
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.Nullable()
        android.content.Context p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot> getItemsArray() {
            return null;
        }
        
        public final void setItemsArray(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public meerkat.picnews.ui.main.MainFragment.NewsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        meerkat.picnews.ui.main.MainFragment.NewsAdapter.ViewHolder holder, int position) {
        }
        
        public NewsAdapter(@org.jetbrains.annotations.NotNull()
        android.content.Context cxt, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.google.firebase.firestore.DocumentSnapshot> itemsArray) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\"\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00130\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n \r*\u0004\u0018\u00010\u00130\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00130\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lmeerkat/picnews/ui/main/MainFragment$NewsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "button_open", "Landroid/widget/Button;", "getButton_open", "()Landroid/widget/Button;", "button_share", "getButton_share", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "locationView", "Landroid/widget/TextView;", "getLocationView", "()Landroid/widget/TextView;", "sourceView", "getSourceView", "textView", "getTextView", "app_debug"})
        public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            private android.widget.ImageView imageView;
            private final android.widget.TextView textView = null;
            private final android.widget.TextView sourceView = null;
            private final android.widget.TextView locationView = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.Button button_share = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.Button button_open = null;
            
            public final android.widget.ImageView getImageView() {
                return null;
            }
            
            public final void setImageView(android.widget.ImageView p0) {
            }
            
            public final android.widget.TextView getTextView() {
                return null;
            }
            
            public final android.widget.TextView getSourceView() {
                return null;
            }
            
            public final android.widget.TextView getLocationView() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.Button getButton_share() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.Button getButton_open() {
                return null;
            }
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            android.view.View itemView) {
                super(null);
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lmeerkat/picnews/ui/main/MainFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lmeerkat/picnews/ui/main/MainFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final meerkat.picnews.ui.main.MainFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}