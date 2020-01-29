package com.example.rxlistview.Fragments;import android.Manifest;import android.content.Intent;import android.content.pm.PackageManager;import android.net.Uri;import android.os.Build;import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.core.app.ActivityCompat;import androidx.fragment.app.Fragment;import android.os.Bundle;import android.util.Log;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.TextView;import android.widget.Toast;import com.example.rxlistview.R;public class AboutFragment extends Fragment {    View view;    TextView txt_call,txt_email,txt_web,txt_dev;    public  static Fragment newInstance(){        AboutFragment aboutFragment = new AboutFragment ();        return aboutFragment;    }    @Nullable    @Override    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {        view = inflater.inflate(R.layout.about_fragment, container, false );        init();        click();        return view;    }    private void click() {        txt_call.setOnClickListener ( new View.OnClickListener ( ) {            @Override            public void onClick(View v) {                if(isPermissionGranted()){                    String phnum = "+923136906307";                    Intent callIntent = new Intent(Intent.ACTION_CALL);                    callIntent.setData(Uri.parse("tel:" + phnum));                    startActivity(callIntent);                }else{                    Toast.makeText ( getActivity (), "permison not granted", Toast.LENGTH_SHORT ).show ( );                }            }        } );        txt_dev.setOnClickListener ( new View.OnClickListener ( ) {            @Override            public void onClick(View v) {                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiverr.com/hamxidesigner?up_rollout=true"));                startActivity(browserIntent);            }        } );        txt_email.setOnClickListener ( new View.OnClickListener ( ) {            @Override            public void onClick(View v) {                Intent i = new Intent(Intent.ACTION_SEND);                i.setType("message/rfc822");                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"Hamza.ali6307@gmail.com"});                i.putExtra(Intent.EXTRA_SUBJECT, "Skip Outfits' Bug/Crash Report");                i.putExtra(Intent.EXTRA_TEXT, "");                try {                    startActivity(Intent.createChooser(i, "Send mail..."));                } catch (android.content.ActivityNotFoundException ex) {                    Toast.makeText( getActivity (), "There are no email clients installed.", Toast.LENGTH_SHORT).show();                }            }        } );        txt_web.setOnClickListener ( new View.OnClickListener ( ) {            @Override            public void onClick(View v) {                Toast.makeText ( getActivity (), "Please Wait for Update link", Toast.LENGTH_SHORT ).show ( );            }        } );    }    private void init() {        txt_call = view.findViewById ( R.id.txt_call );        txt_email = view.findViewById ( R.id.txt_email );        txt_web = view.findViewById ( R.id.txt_web );        txt_dev = view.findViewById ( R.id.txt_dev );    }    public  boolean isPermissionGranted() {        if (Build.VERSION.SDK_INT >= 23) {            if (getActivity ().checkSelfPermission(android.Manifest.permission.CALL_PHONE)                    == PackageManager.PERMISSION_GRANTED) {                Log.v( "TAG", "Permission is granted");                return true;            } else {                Log.v("TAG","Permission is revoked");                ActivityCompat.requestPermissions( getActivity (), new String[]{Manifest.permission.CALL_PHONE}, 1);                return false;            }        }        else { //permission is automatically granted on sdk<23 upon installation            Log.v("TAG","Permission is granted");            return true;        }    }    @Override    public void onRequestPermissionsResult(int requestCode,                                           String permissions[], int[] grantResults) {        switch (requestCode) {            case 1: {                if (grantResults.length > 0                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {                    Toast.makeText(getActivity (), "Permission granted", Toast.LENGTH_SHORT).show();                } else {                    Toast.makeText(getActivity (), "Permission denied", Toast.LENGTH_SHORT).show();                }                return;            }            // other 'case' lines to check for other            // permissions this app might request        }    }}