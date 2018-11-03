package master2018.flink;

        import org.apache.flink.api.common.functions.FilterFunction;
        import org.apache.flink.api.common.functions.MapFunction;
        import org.apache.flink.api.java.tuple.Tuple6;
        import org.apache.flink.core.fs.FileSystem;
        import org.apache.flink.streaming.api.datastream.DataStreamSource;
        import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
        import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class VehicleTelematics {
    public static void main(String[] args) {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        try{
            env.execute("VeichleTelematics");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

