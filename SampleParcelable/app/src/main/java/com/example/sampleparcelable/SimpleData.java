package com.example.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData (int num, String msg){
        number = num;
        message = msg;
    }

    public SimpleData(Parcel src){
        number= src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);
        }

        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };

    // describeContents와 writeToParcel 메서드 2개가 모두 구현 -> Parcelable 인터페이스

    public int describeContents(){
        //직렬화하려는 객체의 유형을 구분할 때 사용
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        // SimpleData 객체 안에 들어있는 데이터를 Parcel 객체로 만드는 역할.
        dest.writeInt(number);
        dest.writeString(message);
    }

}
