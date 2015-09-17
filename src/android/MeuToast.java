package br.com.helpper.meutoast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class MeuToast extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackCtx) throws JSONException{

        if(action.equals("exibe")) {

            final String dados = args.getString(0);
            final String mensagem = "Sua mensagem: "+dados;

            cordova.getActivity().runOnUiThread(new Runnable(){
                public void run() {
                    android.widget.Toast toast = android.widget.Toast.makeText(
                            cordova.getActivity().getApplicationContext(),
                            mensagem,
                            android.widget.Toast.LENGTH_LONG
                    );

                    toast.show();

                    callbackCtx.success();
                }
            });

            return true;

        }
        else
            return false;

    }

}