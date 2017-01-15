package net.myanmarlinks.androidhive;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import net.myanmarlinks.androidhive.rmodel.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by soethihanaung on 1/15/17.
 */

public class RealmController {
    // Singleton Instance
    private static RealmController instance;
    private final Realm realm;

    // Constructor
    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    // Singleton Pattern
    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.setAutoRefresh(true);
    }

    //clear all objects from Book.class
    public void clearAll() {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public RealmResults<Book> getBooks() {

        return realm.where(Book.class).findAll();
    }

    //query a single item with the given id
    public Book getBook(String id) {

        return realm.where(Book.class).equalTo("id", id).findFirst();
    }

    //check if Book.class is empty
    public boolean hasBooks() {
        return !realm.where(Book.class).findAll().isEmpty();
    }

    //query example
    public RealmResults<Book> queryedBooks() {
        return realm.where(Book.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();

    }
}
