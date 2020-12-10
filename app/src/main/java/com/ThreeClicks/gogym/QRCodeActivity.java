package com.ThreeClicks.gogym;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeActivity extends AppCompatActivity {
RelativeLayout qrCodeView;
    private static final String TAG = "QRCodeActivity";
String dirpath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code);
        String text = "qr code";
        Toolbar toolbar=(Toolbar) findViewById(R.id.qrCodeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView imageView = (ImageView) findViewById(R.id.qrCodeImage);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        BitMatrix bitMatrix = null;
        try {
            bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 250, 250);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
        imageView.setImageBitmap(bitmap);
        ImageView printQrCode=(ImageView) findViewById(R.id.printQRCode);
        qrCodeView=(RelativeLayout) findViewById(R.id.qrCodeView);
        printQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfGenerator.getBuilder()
                        .setContext(getBaseContext())
                        .fromViewIDSource()
                        .fromViewID(QRCodeActivity.this,R.id.qrCodeView)
                        /* "fromViewID()" takes array of view ids those MUST BE and MUST BE contained in the inserted "activity" .
                         * You can also invoke "fromViewIDList()" method here which takes list of view ids instead of array. */
                        .setCustomPageSize(3000,3000)
                        /* Here I used ".setCustomPageSize(3000,3000)" to set custom page size.*/
                        .setFileName("Test-PDF")
                        .setFolderName("Test-PDF-folder")
                        .openPDFafterGeneration(true)
                        .build(new PdfGeneratorListener() {
                            @Override
                            public void showLog(String log) {
                                super.showLog(log);
                            }

                            @Override
                            public void onSuccess(SuccessResponse response) {
                                Log.e(TAG, "onSuccess: " );
                                super.onSuccess(response);
                            }

                            @Override
                            public void onFailure(FailureResponse failureResponse) {
                                Log.e(TAG, "onFailure: " );
                                super.onFailure(failureResponse);
                            }
                        });
            }
        });
    }
//    public void layoutToImage(RelativeLayout view) {
//        // get view group using reference
//     //   view = (RelativeLayout) view.findViewById(R.id.print);
//        // convert view group to bitmap
//        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache();
//        Bitmap bm = view.getDrawingCache();
//        Intent share = new Intent(Intent.ACTION_SEND);
//        share.setType("image/jpeg");
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//
//        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
//        try {
//            f.createNewFile();
//            FileOutputStream fo = new FileOutputStream(f);
//            fo.write(bytes.toByteArray());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void imageToPDF() throws FileNotFoundException {
//        try {
//            Document document = new Document();
//            dirpath = android.os.Environment.getExternalStorageDirectory().toString();
//            PDF417Writer.getIns(document, new FileOutputStream(dirpath + "/NewPDF.pdf")); //  Change pdf's name.
//            document.open();
//            Image img = Image.getInstance(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
//            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
//                    - document.rightMargin() - 0) / img.getWidth()) * 100;
//            img.scalePercent(scaler);
//            img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);
//            document.add(img);
//            document.close();
//            Toast.makeText(this, "PDF Generated successfully!..", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//
//        }
//    }
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            onBackPressed();
            return true;
    }
    return super.onOptionsItemSelected(item);
}
}