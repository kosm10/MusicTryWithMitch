package com.hamami.musictrywithmitch.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hamami.musictrywithmitch.R;
import com.hamami.musictrywithmitch.SelectPlayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DialogCreateNewPlaylist extends AppCompatDialogFragment {

    private static final String TAG = "DialogCreateNewPlaylist";

    public interface OnInputListener{
        void sendInput(String input);
        boolean isPlaylistExists(String playlist);
    }

    public OnInputListener mOnInputListener;
    //UI
    private EditText mInput;
    private TextView mActionOk;
    private TextView mActionCancel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: called");
        View view = inflater.inflate(R.layout.dialog_new_playlist,container,false);
        mActionCancel = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);
        mInput = view.findViewById(R.id.dialog_input);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Cancel clicked Closing dialog");
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:  Ok Clicked : capturing input");
                String input = mInput.getText().toString();
                    checkInput(input);
            }
        });
        return view;
    }

    private void checkInput(String input)
    {
        if(input.equals(""))
        {
            Log.d(TAG, "Empty String? input: " +input);
            Toast.makeText(getContext(), "Please Enter playlist Name", Toast.LENGTH_SHORT).show();
        }
        else if(input.isEmpty())
        {
            Log.d(TAG, "The String is null? input: " +input);
            Toast.makeText(getContext(), "Please Enter playlist Name", Toast.LENGTH_SHORT).show();
        }
        else if( isPlaylistAlreadyExists(input) == true )
        {
            Log.d(TAG, "The playlist name already exists. input: " +input);
            Toast.makeText(getContext(), "Please Enter playlist Name that is not already exist", Toast.LENGTH_SHORT).show();
        }
        // it is good Playlist Name
        else
        {
            Log.d(TAG, "checkInput: input is good , we send it now and dismiss dialog");
            mOnInputListener.sendInput(input);
            getDialog().dismiss();

        }
    }

    private boolean isPlaylistAlreadyExists(String input)
    {

       return mOnInputListener.isPlaylistExists(input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mOnInputListener = (OnInputListener) getActivity();
        }
        catch (ClassCastException e)
        {
            Log.e(TAG, "onAttach: ClassCastException: "+e.getMessage());
        }
    }
}
