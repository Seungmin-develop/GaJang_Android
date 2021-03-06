package com.minrd.gajang.view.adapter

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.minrd.gajang.R
import androidx.navigation.fragment.navArgs
import android.widget.ImageView
import androidx.databinding.adapters.ImageViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.FragmentNearybyStoreDetailShowBinding
import com.minrd.gajang.databinding.PriceCompareItemViewBinding


class PriceCompareAdapter(var dataList: MutableList<ResponseNecessariesData> = ArrayList()): RecyclerView.Adapter<PriceCompareAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: PriceCompareItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(myData: ResponseNecessariesData){
            binding.priceCompareItemData = myData
            //Log.d(TAG, "bind: $myData")
            setOnMarketImage(myData.M_NAME.toString())
        }

        private fun setOnMarketImage(marketName:String){
            if(marketName.contains("롯데슈퍼")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.lottesuper)
            }
            else if(marketName.contains("이마트")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.emart)
            }
            else if(marketName.contains("홈플러스")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.homeplus)
            }
            else if(marketName.contains("현대백화점")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.hyundaidepartmentstore)
            }
            else if(marketName.contains("신세계백화점")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.sinsagae)
            }
            else if(marketName.contains("롯데백화점")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.lottedepart)
            }
            else if(marketName.contains("뉴코아")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.newcore)
            }
            else if(marketName.contains("하나로")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.hanaro)
            }
            else if(marketName.contains("NC")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.ncdepart)
            }
            else if(marketName.contains("롯데마트")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.lottemart)
            }
            else{
                binding.priceCompareItemViewImage.setImageResource(R.drawable.market)
            }
        }

    }

    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding= PriceCompareItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size


    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }


}