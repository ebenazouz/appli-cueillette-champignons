package com.example.dzielinski.champignon;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    public ArrayList<Champignon> champignons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        parseXML();
        ListeNomChampi liste = new ListeNomChampi(champignons);
        List<String> listeNom = liste.get();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listeNom);
        mListView.setAdapter(adapter);


    }

    private void parseXML(){
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("listechampignons.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);
        }
        catch(XmlPullParserException e){

        }
        catch(IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        champignons = new ArrayList<>();
        int eventType = parser.getEventType();
        Champignon currentChampi = null;

        while(eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch(eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if("champignon".equals(eltName)) {
                        currentChampi = new Champignon();
                        champignons.add(currentChampi);
                    } else if(currentChampi != null) {
                        if("nom".equals(eltName)){
                            currentChampi.nom = parser.nextText();
                        } else if("nomScientifique".equals(eltName)) {
                            currentChampi.nomScientifique = parser.nextText();
                        } else if("chapeau".equals(eltName)) {
                            currentChampi.chapeau.add(parser.nextText());
                        } else if ("marge".equals(eltName)) {
                            currentChampi.marge.add(parser.nextText());
                        } else if ("pied".equals(eltName)) {
                            currentChampi.pied.add(parser.nextText());
                        } else if("lame".equals(eltName)) {
                            currentChampi.lame = parser.nextText();
                        } else if ("couleurChapeau".equals(eltName)) {
                            currentChampi.couleurChapeau.add(parser.nextText());
                        } else if ("couleurHymenium".equals(eltName)) {
                            currentChampi.couleurHymenium.add(parser.nextText());
                        } else if ("couleurDuPied".equals(eltName)) {
                            currentChampi.couleurDuPied.add(parser.nextText());
                        } else if("comestibilite".equals(eltName)) {
                            currentChampi.comestibilite = parser.nextText();
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
    }
}
