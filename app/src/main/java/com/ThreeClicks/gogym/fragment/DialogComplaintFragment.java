package com.ThreeClicks.gogym.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ThreeClicks.gogym.R;

import static android.app.Activity.RESULT_OK;


public class DialogComplaintFragment extends DialogFragment {
    Button addComplaintImage;
    ImageView complaintImage;
    Button submit;
    EditText complaintEditText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_dialog_complaint, container, false);
        addComplaintImage=(Button) root.findViewById(R.id.addComplaintImage);
        complaintImage=(ImageView) root.findViewById(R.id.complaintImage);
        complaintEditText=(EditText) root.findViewById(R.id.complaintEdittext);
        addComplaintImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i,1);
            }
        });
        submit=(Button) root.findViewById(R.id.complaintSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(complaintEditText.getText().toString().equals("")){
                      Toast.makeText(getContext(), "Your Complaint is empty", Toast.LENGTH_SHORT).show();
                  }else {
                      dismiss();
                  }
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK
                && data != null) {
            Uri filePath=data.getData();
            complaintImage.setVisibility(View.VISIBLE);
            complaintImage.setImageURI(filePath);
        }
    }
}