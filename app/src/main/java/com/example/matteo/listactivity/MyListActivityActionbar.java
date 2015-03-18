package com.example.matteo.listactivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;


public class MyListActivityActionbar extends ListActivity implements ActionMode.Callback
{

    protected Object mActionMode;
    public int selectedItem = -1;

    @Override
    protected void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(mActionMode != null)
                {
                    return false;
                }

                selectedItem = position;

                MyListActivityActionbar.this.startActionMode(MyListActivityActionbar.this);
                view.setSelected(true);
                return true;
            }
        });

    }

    private void show()
    {
        Toast.makeText(MyListActivityActionbar.this, String.valueOf(selectedItem), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu)
    {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.contextual,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false; // Return false if nothing is done
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item_delete:
                show();
                mode.finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode)
    {
        mActionMode = null;
        selectedItem = -1;
    }


}
