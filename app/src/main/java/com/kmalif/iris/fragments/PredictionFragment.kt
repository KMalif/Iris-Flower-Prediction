package com.kmalif.iris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmalif.iris.databinding.FragmentPredictionBinding
import com.kmalif.iris.ml.Iris
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer


class PredictionFragment : Fragment() {
    private lateinit var binding: FragmentPredictionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentPredictionBinding.inflate(layoutInflater)
        btnPredictAction()
        return binding.root
    }


    private fun btnPredictAction(){
        binding.BTnPrediction.setOnClickListener {
            doPrediction()
        }
    }

    private fun doPrediction(){
        //UserInput
        val Slength : Float = binding.ETSepalLenght.text.toString().toFloat()
        val SWidth : Float = binding.ETSepalWidth.text.toString().toFloat()
        val Plength : Float = binding.ETPetalLength.text.toString().toFloat()
        val PWidth : Float = binding.ETPetalWidth.text.toString().toFloat()

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
        showPrediction(outputFeature0)
        // Releases model resources if no longer used.
        model.close()
    }

    private fun showPrediction(outputFeature0 : FloatArray ){
        binding.TVResult.setText("Iris Setosa " + outputFeature0[0].toString() + "/n"
                                + "Iris Versi color " + outputFeature0[1].toString() + "/n"
                                + "Iris Virginica " + outputFeature0[2].toString()
        )
    }

}