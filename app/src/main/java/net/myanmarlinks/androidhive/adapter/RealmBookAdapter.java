package net.myanmarlinks.androidhive.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.myanmarlinks.androidhive.rmodel.Book;

import io.realm.OrderedRealmCollection;

/**
 * Created by soethihanaung on 1/15/17.
 */

public class RealmBookAdapter extends RealmModelAdapter<Book> {
    public RealmBookAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Book> data) {
        super(context, data);
    }
}
