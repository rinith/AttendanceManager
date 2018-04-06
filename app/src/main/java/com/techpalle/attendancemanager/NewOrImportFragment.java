package com.techpalle.attendancemanager;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewOrImportFragment extends Fragment {

    Button b1,b2;
   ;


    public NewOrImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_or_import, container, false);

        b1 = v.findViewById(R.id.button1);
        b2 = v.findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m = (MainActivity) getActivity();
                m.loadSubjectList();
            }
        });


        return v;
    }

}
