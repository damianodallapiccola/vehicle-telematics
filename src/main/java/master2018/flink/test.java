package master2018.flink;


import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class test{

    public static void main(String[] args) {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();
        String inFilePath = args[0];
        String outFilePath = args[1];
        DataStreamSource<String> source = env.readTextFile(inFilePath);
        SingleOutputStreamOperator<Tuple3<Long, String, Double>> map = source.map(new MapFunction<String, Tuple3<Long, String, Double>>() {
            @Override
            public Tuple3<Long, String, Double> map(String value) throws Exception {

                String[] arrayv = value.split(",");

                Tuple3<Long, String, Double> out =
                        new Tuple3(Long.parseLong(arrayv[0])
                                , arrayv[1], Double.parseDouble(arrayv[2]));

                return out;
            }
        });


        map.writeAsText(outFilePath);
        try {
            env.execute("ValerioSlideProgram1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
