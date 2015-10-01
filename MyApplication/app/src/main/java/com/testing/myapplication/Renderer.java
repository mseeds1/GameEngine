package com.testing.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

/**
 * Created by WINDOWS 8 on 30/09/2015.
 */


public class Renderer extends RajawaliRenderer {

    Sphere mEarthSphere;

    public Renderer(Context context) {
        super(context);
        setFrameRate(60);

    }

    @Override
    protected void initScene() {
        mEarthSphere = new Sphere(1, 24, 24);

        Material material = new Material();
        material.enableLighting(true);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);

        Texture earthTexture = new Texture("Earth", R.drawable.earth);
        try {
            material.addTexture(earthTexture);
        } catch (Exception e) {
            Log.e("ERROR" ,"Texture loading failed");
        }
        mEarthSphere.setMaterial(material);

        getCurrentScene().addChild(mEarthSphere);
        getCurrentCamera().setZ(4.2f);
    }

    @Override
    public void onOffsetsChanged(float v, float v1, float v2, float v3, int i, int i1) {

    }

    @Override
    public void onTouchEvent(MotionEvent motionEvent) {

    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        mEarthSphere.rotate(Vector3.Axis.Y, 1.0);
    }
}
