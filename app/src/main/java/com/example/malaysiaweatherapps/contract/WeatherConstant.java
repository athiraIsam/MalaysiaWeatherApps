package com.example.malaysiaweatherapps.contract;

import com.example.malaysiaweatherapps.R;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public abstract class  WeatherConstant {
    public final static String FORECAST = "FORECAST";
    public final static String GENERAL = "GENERAL";
    public final static String AUTHORIZATION = "Authorization";
    public final static String API_KEY = "METToken 5624f4cfb2d68787c984e8f6d43878c021f71c1d";
    public final static String FSIGW = "FSIGW";
    public final static String FMINT = "FMINT";
    public final static String FMAXT = "FMAXT";
    public final static String FGM = "FGM";
    public final static String FGA = "FGA";
    public final static String FGN = "FGN";

    public enum GeneralForecastQuery {
        datasetid(R.string.datasetid),
        datacategoryid(R.string.datacategoryid),
        locationid(R.string.locationid),
        start_date(R.string.start_date),
        end_date(R.string.end_date),
        lang(R.string.lang);


        private int value;

        GeneralForecastQuery(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static GeneralForecastQuery getById(int id) {
            for (GeneralForecastQuery v : values()) {
                if (v.getValue() == id) {
                    return v;
                }
            }
            return GeneralForecastQuery.datasetid;
        }
    }

    public static String GetDayName(int day)
    {
        switch (day)
        {
            case 1:return "SUNDAY";

            case 2: return "MONDAY";

            case 3: return "TUESDAY";

            case 4: return "WEDNESDAY";

            case 5: return "THURSDAY";

            case 6: return "FRIDAY";

            case 7: return "SATURDAY";

        }
        return "UKNOWN";
    }

    public static HashMap<Integer,String> GetAllLocations()
    {
        HashMap<Integer,String> state = new HashMap<>();

        state.put(1,"JOHOR");
        state.put(2,"KEDAH");
        state.put(3,"KELANTAN");
        state.put(4,"KUALA LUMPUR");
        state.put(5,"LABUAN");
        state.put(6,"MELAKA");
        state.put(7,"NEGERI SEMBILAN");
        state.put(8,"PAHANG");
        state.put(9,"PULAU PINANG");
        state.put(10,"PERAK");
        state.put(11,"PERLIS");
        state.put(12,"PUTRAJAYA");
        state.put(13,"SABAH");
        state.put(14,"SARAWAK");
        state.put(15,"SELANGOR");
        state.put(16,"TERENGGANU");


        return state;
    }
}
