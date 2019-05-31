package top.keepmoving.kmweb.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String s = jsonParser.getText().trim();

        try {

            logger.info("JSON日期解析数据:{}", s);

            return sdf.parse(s);

        } catch (ParseException e) {
            logger.error("JSON日期解析异常:{}", s, e);
        }
        return deserializationContext.parseDate(s);
    }
}
