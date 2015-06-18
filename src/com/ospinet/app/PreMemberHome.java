package com.ospinet.app;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.devspark.sidenavigation.ISideNavigationCallback;
import com.devspark.sidenavigation.SideNavigationView;
import com.devspark.sidenavigation.SideNavigationView.Mode;
import com.ospinet.app.R;

public class PreMemberHome extends SherlockActivity implements ISideNavigationCallback {
	private SideNavigationView sideNavigationView;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
setContentView(R.layout.home_new);
showActionBar();
sideNavigationView = (SideNavigationView) findViewById(R.id.side_navigation_view);
sideNavigationView.setMenuItems(R.menu.side_navigation_menu);
sideNavigationView.setMenuClickCallback(this);
sideNavigationView.setMode(Mode.LEFT);

}

@Override
public void onSideNavigationItemClick(int itemId) {
	switch(itemId)
	{
case R.id.side_navigation_menu_item1:
    Intent i = new Intent(PreMemberHome.this, LoginActivity.class);
	i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	i.putExtra("EXIT", true);

	PreMemberHome.this.startActivity(i);

	break;

case R.id.side_navigation_menu_item2:
     Intent records = new Intent(PreMemberHome.this, Member_Home.class);
     PreMemberHome.this.startActivity(records);

     break;

case R.id.side_navigation_menu_item3:
     Intent help = new Intent(PreMemberHome.this, com.ospinet.app.help.class);
     PreMemberHome.this.startActivity(help);

     break;

        default:
    return;
    }
   // finish();
}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	Intent i = new Intent(PreMemberHome.this,LoginActivity.class);
	this.startActivity(i);
	finish();

}
public void showMembers(View v)
{
	try
	{
		Intent intent = new Intent(PreMemberHome.this, Member_Home.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);//finish();

	}
	catch(Exception ex)
	{
		
	}
}
public void logout(View v)
{
	try
	{
		 Intent i = new Intent(PreMemberHome.this, LoginActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.putExtra("EXIT", true);

			PreMemberHome.this.startActivity(i);

	}
	catch(Exception ex)
	{
		
	}
}
public void help(View v)
{
	try
	{
		 Intent i = new Intent(PreMemberHome.this, help.class);
			
			PreMemberHome.this.startActivity(i);

	}
	catch(Exception ex)
	{
		
	}
}
private void showActionBar() {
    LayoutInflater inflator = (LayoutInflater) this
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View v = inflator.inflate(R.layout.menu1, null);
com.actionbarsherlock.app.ActionBar actionBar = getSupportActionBar();
actionBar.setDisplayHomeAsUpEnabled(false);
actionBar.setDisplayShowHomeEnabled (false);
actionBar.setDisplayShowCustomEnabled(true);
actionBar.setDisplayShowTitleEnabled(false);
actionBar.setCustomView(v);
ImageButton imgAdd = (ImageButton) v.findViewById(R.id.add); //it's important to use your actionbar view that you inflated before
ImageButton imgMenu = (ImageButton) v.findViewById(R.id.options);	
imgAdd.setOnClickListener(new OnClickListener() {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(PreMemberHome.this, MemberActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("EXIT", true);
		PreMemberHome.this.startActivity(intent);
        
	}
});
imgMenu.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 sideNavigationView.toggleMenu();
		 RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel);
         rel.bringChildToFront(sideNavigationView);
        
	}
});

ImageButton imgLogo = (ImageButton) v.findViewById(R.id.logo);
TextView txtLogoName = (TextView) v.findViewById(R.id.logoName);

imgLogo.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(PreMemberHome.this,PreMemberHome.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(i);
	}
});
txtLogoName.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(PreMemberHome.this,PreMemberHome.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(i);
	}
});



}


}
