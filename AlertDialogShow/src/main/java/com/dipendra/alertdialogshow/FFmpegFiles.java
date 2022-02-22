package com.dipendra.alertdialogshow;

import android.util.Log;

import com.arthenica.mobileffmpeg.ExecuteCallback;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.arthenica.mobileffmpeg.FFmpegExecution;

public class FFmpegFiles {
    public static void mergevideoandaudio(String inputvideo,String inputaudio,String outputvideo)
    {
        String[] c = {"-i",inputvideo
                , "-i",inputaudio,"-c:v", "copy", "-c:a", "aac", "-map", "0:v:0", "-map", "1:a:0", "-shortest",
                outputvideo   };

        FFmpeg.executeAsync(c, new ExecuteCallback() {
            @Override
            public void apply( long executionId, int returnCode ) {
                Log.d("hello" , "return  " + returnCode);
                Log.d("hello" , "executionID  " + executionId);
                Log.d("hello" , "FFMPEG  " +  new FFmpegExecution(executionId,c));

            }
        });
    }
    public void videotoaudio(String inputvideo,String outputaudio) {
        String[] co = {"-i",inputvideo,"-vn",outputaudio };
        FFmpeg.executeAsync(co, new ExecuteCallback() {
            @Override
            public void apply( long executionId, int returnCode ) {
                Log.d("hello" , "return  " + returnCode);
                Log.d("hello" , "executionID  " + executionId);
                Log.d("hello" , "FFMPEG  " +  new FFmpegExecution(executionId,co));

            }
        });
    }
    public void trimvideo(String inputvideo,String outputvideo)
    {
        String[] co ={"-y", "-i", inputvideo,"-ss", "00:00:03" , "-to", "00:00:45" , "-c", "copy",outputvideo};
        FFmpeg.executeAsync(co, new ExecuteCallback() {
            @Override
            public void apply( long executionId, int returnCode ) {
                Log.d("hello" , "return  " + returnCode);
                Log.d("hello" , "executionID  " + executionId);
                Log.d("hello" , "FFMPEG  " +  new FFmpegExecution(executionId,co));

            }
        });

    }
}
