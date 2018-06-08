package com.example.seniordeveloper.aqmapuz;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Bus;
import Model.Station;
import Model.StationBuses;
import Modules.DirectionFinder;
import Modules.DirectionFinderListener;
import Modules.Route;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private GoogleMap mMap;
    private ImageView btnFindPath;
    private ImageView btn2;
    private EditText etOrigin;
    private EditText etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    private Cursor employees;
    private MyDatabase db;
    String first="",second="",firstWay="",secondWay="",thirdWay="";

    private String getTransports(String first, String second) {

        String result="";
        db = new MyDatabase(this);

          // getting database from bus table
        String [] sqlSelect = {"id", "number"};
        String sqlTables = "Bus";
        employees = db.getEmployees(sqlSelect,sqlTables);
        List<Bus> buses = getBus(employees);


        // getting database from station table
        String [] sqlSelect1 = {"Id", "name","orientr"};
        String sqlTables1 = "Station";
        employees = db.getEmployees(sqlSelect1,sqlTables1);
        List<Station> stations = getStation(employees);

        // getting database from stationbuses table
        String [] sqlSelect12 = {"Id", "StationID","BusID"};
        String sqlTables12 = "StationBuses";
        employees = db.getEmployees(sqlSelect12,sqlTables12);
        List<StationBuses> stationbuses = getStationBuses(employees,buses,stations);

                   String FirstBuses= "",SecondBuses="";
           for(int i=0;i<stationbuses.size();i++){
               if(stationbuses.get(i).StationID.toLowerCase().equals(first)){
                  FirstBuses+=stationbuses.get(i).BusID+" ";
               }
               else if(stationbuses.get(i).StationID.toLowerCase().equals(second)){
                   SecondBuses+=stationbuses.get(i).BusID+" ";
               }
           }
        String[] a = FirstBuses.split("\\s+");
        String[] b = SecondBuses.split("\\s+");
 firstWay+="Peresadka qilmasdan borish mumkin bo'lgan avtobuslar:\n";
 String pryamoy="";  int count=0;
        for (String x : a) {
            for (String y : b) {
                if (x .equals( y)) {
                    firstWay+="["+x+"] ";
                    pryamoy+=x+" ";
                    count=1;
                }
            }
        }

          // found first optimal route before there
        //  find second route



        String[] a_station;
        String[] b_station;


        String[] pryam = pryamoy.split("\\s+");



        for (String x : a) {
                                 a_station = findBusStations(x,stationbuses);
            for (String y : b) {

                if(check(x,y,pryam)){

                                   b_station = findBusStations(y,stationbuses);

               for(String abekat : a_station){

                   for(String bbekat : b_station){

                       if (abekat .equals( bbekat)) {

                           if(count>3){ thirdWay+=abekat+" bekati orqali ["+x+"],["+y+"] da \n";}
                           secondWay+=abekat+" bekati orqali ["+x+"],["+y+"] da \n";
                           count++;
                       }
                   }
               }
                }
            }
        }



if(count>0 || count==1)result="hello";
else {result=null;}

        return result;
    }

 private boolean check(String x, String y, String[] pryam) {

 int count=0;
        if(!x.equals(y)){
                 if(Arrays.asList(pryam).contains(x) || Arrays.asList(pryam).contains(y)){
                     count++;
                  }
         }
    else count++;

        if(count>0){
            return false;
        }
        else return true;
    }


    private String[] findBusStations(String x,List<StationBuses> stationbuses) {
        String str="";
        for(int i=0;i<stationbuses.size();i++)
        {
            if(stationbuses.get(i).BusID.equals(x)){
                str+=stationbuses.get(i).StationID+" ";
            }
        }
        String[] a = str.split("\\s+");
        return a;
    }

    private List<StationBuses> getStationBuses(Cursor employees, List<Bus> buses, List<Station> stations) {
        List<StationBuses> stationbuses =  new ArrayList<>();
        employees.moveToFirst(); StationBuses data=null;
        while(!employees.isAfterLast()) {
            String id = employees.getString(employees.getColumnIndex("id"));
            String StationID = employees.getString(employees.getColumnIndex("StationID"));
            String BusID = employees.getString(employees.getColumnIndex("BusID"));
            data = new StationBuses();
            data.StationID=StationID;
            data.BusID=BusID;
            data.id=Integer.parseInt(id);
            stationbuses.add(data);
            employees.moveToNext();
        }
        employees.close();
//  before there all database is loaded

// full to StationBuses table BusNumbers instead BusID
        int StatBusid=0;

        for(int i=0;i<stationbuses.size();i++){

            StatBusid=Integer.parseInt(stationbuses.get(i).BusID);

            for(int j=0;j<buses.size();j++){
                if(StatBusid==buses.get(j).id){
                    stationbuses.get(i).BusID=buses.get(j).number; break;
                }
            }


        }
// full to StationBuses table BusStationNames instead StationsID
    int StatStatid=0;

        for(int i=0;i<stationbuses.size();i++){

            StatStatid=Integer.parseInt(stationbuses.get(i).StationID);

            for(int j=0;j<stations.size();j++){
                if(StatStatid==stations.get(j).id){
                    stationbuses.get(i).StationID=stations.get(j).name; break;
                }
            }


        }






        return stationbuses;

    }

    private List<Station> getStation(Cursor employees) {
        List<Station> stations =  new ArrayList<>();
        employees.moveToFirst(); Station data=null;
        while(!employees.isAfterLast()) {
            String id = employees.getString(employees.getColumnIndex("id"));
            String name = employees.getString(employees.getColumnIndex("name"));
            String orientr = employees.getString(employees.getColumnIndex("orientr"));
            data = new Station();
            data.name=name;
            data.orientr=orientr;
            data.id=Integer.parseInt(id);
            stations.add(data);
            employees.moveToNext();
        }
        employees.close();
        return stations;
    }
    public List<Bus> getBus(Cursor cursor){
        List<Bus> buses =  new ArrayList<>();
        cursor.moveToFirst(); Bus data=null;
     while(!cursor.isAfterLast()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
        data = new Bus();
            data.number=number;
            data.id=Integer.parseInt(id);
            buses.add(data);
         cursor.moveToNext();
        }
        cursor.close();
        return buses;
    }
    public String[] getData(Cursor cursor,String columnName){

        cursor.moveToFirst();
        ArrayList<String> names = new ArrayList<String>();
        while(!cursor.isAfterLast()) {
            names.add(cursor.getString(cursor.getColumnIndex(columnName)));
            cursor.moveToNext();
        }
        cursor.close();
        return names.toArray(new String[names.size()]);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        employees.close();
        db.close();
    }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btnFindPath = (ImageView) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etDestination);
        etDestination = (EditText) findViewById(R.id.etOrigin);
        btn2 = (ImageView) findViewById(R.id.btnTashBus);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



             AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(MapsActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(MapsActivity.this);
                }
                    first=etOrigin.getText().toString().toLowerCase();
                second=etDestination.getText().toString().toLowerCase();
firstWay=""; secondWay=""; thirdWay="";
                String result =  getTransports(first,second);
//                   if(first.equals("беруний") && second.equals("сергели") || first.equals("beruniy") && second.equals("sergeli")){
                if(result!=null && result!="" && result.length()>2){
                       builder.setTitle("Natija : ")
//                               .setMessage("\t1. Beruniy bekatidan Sergeli bekatiga boruvchi avtobuslar ro'yhati: \n  [131]" +
//                                       "\n\n\t2 .Beruniy bekatidan -> Chilonzor bekatiga metro orqali boring  \n Chilonzor bekatidan Sergeli bekatiga boruvchi avtobuslar ro'yhati :\n [8], [74], [131], [86], [48], [112]." +
//                                       "\n\n\t3 .Beruniy bekatidan -> Oybek bekatiga metro orqali boring \n Oybek bekatidan Sergeli bekatiga boruvchi avtobuslar ro'yhati : \n  [38], [58]" +
//                                       "")
                               .setMessage("'"+etOrigin.getText().toString()+"' bekatidan '"+etDestination.getText().toString()+"' bekatiga boradigan marshrut yo'nalishlari : \n\n "+ "\t\t\t\t\t\t Variant - 1\n "+firstWay+"" +
                                       "\n\t\t\t\t\t\t Variant - 2\n  "+secondWay+"\n\t\t\t\t\t\t Variant - 3\n  "+thirdWay+" ")
                               .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which) {}})
                               .setIcon(android.R.drawable.ic_menu_search)
                               .show();
                     }

                else {
                            builder.setTitle("Hatolik ")
                            .setMessage("Malumotlar bazasi hali kiritilmagan...")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which) {}})
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                     }

            }
        });

        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }



    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    private void sendRequest() {
        mMap.clear();

        String origin = etOrigin.getText().toString();
        String destination = etDestination.getText().toString();

        if (origin.isEmpty()) {
            Toast.makeText(this, "1chi manzilingiz!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "2chi manzilingiz!", Toast.LENGTH_SHORT).show();
            return;
        }
        first=origin;
        second=destination;
         origin+=" Ташкент Узбекистан";
       destination+=" Ташкент Узбекистан";
        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(41.346004, 69.206542);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Beruniy Metro Bekati"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14f));
    }


    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Iltimos kuting...",
                "Yo'nalish Qidirilmoqda..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {

            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);

            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 12.5f));

        }

    }
}
