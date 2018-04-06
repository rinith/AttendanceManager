package com.techpalle.attendancemanager;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectListFragment extends Fragment {

    EditText ed1;



    public SubjectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_subject_list, container, false);
        ed1 = v.findViewById(R.id.entersub);




        FloatingActionButton add = (FloatingActionButton) v.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              MainActivity m = (MainActivity) getActivity();
              String sub = ed1.getText().toString().trim();
              m.addSubject(sub);
              ed1.setText("");

            }
        });





        return v;
    }

}
