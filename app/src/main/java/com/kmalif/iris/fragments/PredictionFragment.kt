package com.kmalif.iris.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmalif.iris.SetosaActivity
import com.kmalif.iris.VersicolorActivity
import com.kmalif.iris.VirginicaActivity
import com.kmalif.iris.databinding.FragmentPredictionBinding
import com.kmalif.iris.ml.Iris
import com.kmalif.iris.models.History
import io.realm.Realm
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer


class PredictionFragment : Fragment() {
    private lateinit var binding: FragmentPredictionBinding
    private lateinit var realm : Realm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentPredictionBinding.inflate(layoutInflater)
        btnPredictAction()
        setupRealm()
        return binding.root
    }


    private fun btnPredictAction(){
        binding.BTnPrediction.setOnClickListener {
            doPrediction()
        }
    }

    private fun doPrediction(){
        //UserInput
        val Slength : Float = binding.ETSepalLenght.text.toString().trim().toFloat()
        val SWidth : Float = binding.ETSepalWidth.text.toString().trim().toFloat()
        val Plength : Float = binding.ETPetalLength.text.toString().trim().toFloat()
        val PWidth : Float = binding.ETPetalWidth.text.toString().trim().toFloat()

        val byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4*4)
        byteBuffer.putFloat(Slength)
        byteBuffer.putFloat(SWidth)
        byteBuffer.putFloat(Plength)
        byteBuffer.putFloat(PWidth)

        val model = Iris.newInstance(requireActivity())

        // Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 4), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray
        val irisSetosa = outputFeature0[0] * 100
        val irisVersicolor = outputFeature0[1] * 100
        val irisVirginica = outputFeature0[2] * 100
        val result = "Iris Setosa ${irisSetosa.toString()} % /n" +
                "Iris Versicolor ${irisVersicolor.toString()} % /n" +
                "Iris Virginica ${irisVirginica.toString()} % "

        //Add to DB
        addHistory(Slength.toString(),SWidth.toString(), Plength.toString(), PWidth.toString(), result )
//        showPrediction(result)
        toResultActivity(irisSetosa.toInt(), irisVersicolor.toInt(), irisVirginica.toInt())
        // Releases model resources if no longer used.
        model.close()
    }

//    private fun showPrediction(result : String ){
//        binding.TVResult.setText(result)
//    }

    private fun setupRealm(){
        Realm.init(activity)
        realm = Realm.getDefaultInstance()
    }

    private fun addHistory(SLength : String, SWidth : String, PLength : String, PWidth : String, Result : String){
        realm.beginTransaction()
        val currentId = realm.where(History::class.java).max("id")
        val nextId = if (currentId == null) 1 else currentId.toInt()+1
        val histories = realm.createObject(History::class.java)
        histories.setId(nextId)
        histories.setSLength(SLength)
        histories.setSWidth(SWidth)
        histories.setPLength(PLength)
        histories.setPWidth(PWidth)
        histories.setResult(Result)
        realm.commitTransaction()
    }

    private fun toResultActivity(setosa : Int, versicolor: Int, virginica: Int){
        if (setosa > versicolor && setosa >virginica){
            startActivity(Intent(activity, SetosaActivity::class.java).putExtra("setosa", setosa))
        }
        else if (versicolor > setosa && versicolor>virginica){
            startActivity(Intent(activity, VersicolorActivity::class.java).putExtra("versicolor", versicolor))
        }
        else if (virginica > setosa && virginica > versicolor){
            startActivity(Intent(activity, VirginicaActivity::class.java).putExtra("virginica", virginica))
        }

    }

}