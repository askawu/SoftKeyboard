package com.example.android.softkeyboard;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactListActivity extends Activity {

    private ListView mContactListView;
    private ArrayAdapter mContactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        mContactListView = (ListView)findViewById(R.id.contactListView);
        mContactListAdapter  = new ArrayAdapter(this, R.layout.contact_list_item, R.id.contactName);
        Cursor cr = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                                               null,
                                               null,
                                               null,
                                               ContactsContract.Contacts.DISPLAY_NAME);
        while (cr.moveToNext()) {
            String name = cr.getString(cr.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            mContactListAdapter.add(name);
        }

        mContactListView.setAdapter(mContactListAdapter);
    }
}
