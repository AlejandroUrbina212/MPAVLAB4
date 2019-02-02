package com.app.mpav_lab4.mpav_lab4

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddressFragment : Fragment(), OnMapReadyCallback {

    companion object {
        private const val TAG = "MapFragment"
    }

    private lateinit var rootView: View
    private lateinit var mMap: GoogleMap
    private lateinit var mMapView: MapView


    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar!!.title = "Google Map"

        try {
            rootView = inflater.inflate(R.layout.fragment_address, container, false)
            MapsInitializer.initialize(this.activity!!)
            mMapView = rootView.findViewById(R.id.map) as MapView
            mMapView.onCreate(savedInstanceState)
            mMapView.getMapAsync(this)
        } catch (e: InflateException) {
            Log.e(TAG, "Inflate exception")
        }

        return rootView
    }

    override fun onPause() {
        super.onPause()
        mMapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mMapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView.onLowMemory()
    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!


        val gt = LatLng(14.604713, -90.489377)
        mMap.addMarker(MarkerOptions().position(gt).title("Guatemala City"))

        val cameraPosition = CameraPosition.Builder().target(gt).zoom(12.0f).build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        mMap.moveCamera(cameraUpdate)

    }
}