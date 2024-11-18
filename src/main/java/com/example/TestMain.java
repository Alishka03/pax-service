package com.example;

import com.example.paxservice.dto.PaxDataDTO;
import com.pax.market.api.sdk.java.api.base.dto.Result;
import com.pax.market.api.sdk.java.api.goinsight.GoInsightApi;
import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;

import java.util.List;
import java.util.TimeZone;

import static com.example.paxservice.dto.PaxDataDTO.fromRowList;

public class TestMain {
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT+6");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api", "0JZJ3J7JP9AXKI3QMW1K", "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);
        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("t3q6tkn9"); //hzsv73by
        System.out.println(result);
        DataQueryResultDTO data = result.getData();
        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
//        System.out.println(rows);
        List<DataQueryResultDTO.Row> rows1 = rows.get(0);
        DataQueryResultDTO.Row row = rows1.get(0);

        System.out.println(row);

    }
}
