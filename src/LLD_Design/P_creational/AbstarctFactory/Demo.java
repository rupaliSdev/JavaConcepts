package LLD_Design.P_creational.AbstarctFactory;

public class Demo {

    public static void main(String[] args) {
        CloudFactory factory = new AwsFactory();

        ComputeInstance compute = factory.createCompute();
        StorageBucket storage = factory.createStorage();
        Database database = factory.createDatabase();

        compute.start();
        storage.store("data.csv");
        database.connect();

    }
}

interface ComputeInstance {
    void start();
}

interface StorageBucket {
    void store(String file);
}

interface Database {
    void connect();
}

class AWSEc2 implements ComputeInstance{

    @Override
    public void start() {
        System.out.println("aws compute");
    }
}

class AWSS3 implements StorageBucket{

    @Override
    public void store(String file) {
        System.out.println("aws storage");
    }
}
class AWSRDS implements Database{

    @Override
    public void connect() {
        System.out.println("aws rds");
    }
}


class AzureVM implements ComputeInstance{

    @Override
    public void start() {
        System.out.println("AzureVM");
    }
}

class AzureBlob implements StorageBucket{

    @Override
    public void store(String file) {
        System.out.println("AzureBlob");
    }
}
class AzureSQL implements Database{

    @Override
    public void connect() {
        System.out.println("AzureSQL");
    }
}

interface CloudFactory {

    ComputeInstance createCompute();

    StorageBucket createStorage();

    Database createDatabase();
}
class AwsFactory implements CloudFactory {

    public ComputeInstance createCompute() {
        return new AWSEc2();
    }

    public StorageBucket createStorage() {
        return new AWSS3();
    }

    public Database createDatabase() {
        return new AWSRDS();
    }
}

class AzureFactory implements CloudFactory {

    public ComputeInstance createCompute() {
        return new AzureVM();
    }

    public StorageBucket createStorage() {
        return new AzureBlob();
    }

    public Database createDatabase() {
        return new AzureSQL();
    }
}