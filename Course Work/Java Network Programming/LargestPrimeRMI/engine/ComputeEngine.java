/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: December 12, 2022
Assignment 3

Acknowledgement: This code was based on the programs from the guide:
https://docs.oracle.com/javase/tutorial/rmi/overview.html
and is based on code from https://landing.athabascau.ca/file/view/747375/rmi-example
as per the assignment requirements.

Purpose: To create a Java rmi client/server system that allows the client to pass a range
to the server, then the server will calculate the greatest prime number within that range, inclusive.

Instructions(CLI):
To compile this program enter the command into the command line (In a UNIX based OS):
javac compute/Compute.java compute/Task.java (To compile the Compute class)
jar cvf compute.jar compute/*.class (To create the compute.jar file for the server)

javac -cp {directory path of this program}/compute.jar engine/ComputeEngine.java (compile the Compute engine
linking to the compute.jar file earlier.)

javac -cp {directory path of this program}/compute.jar client/ComputeLargePrime.java client/LargePrime.java

To start the server (In a UNIX based system):
First enable the rmiregistry with the following command:
rmiregistry &

Then:
java -Djava.security.policy=server.policy engine.ComputeEngine (where server.policy is the file containing
the security policy for the server.)

To start the client program (In a UNIX based system):
java -Djava.security.policy=client.policy client.ComputeLargePrime {server address} {input}

Test Plan:
Good input (client side):
Test 1: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 23 (Client)

Expected Result: 23

Actual Result:
As expected.

Test 2: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 22 (Client)

Expected Result: 19

Actual Result:
As expected.

Test 3: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 7950 (Client)

Expected Result: 7949

Actual Result:
As expected.

Test 4: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 2 (Client)

Expected Result: 2

Actual Result:
As expected.

Test 5: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 3 (Client)

Expected Result: 3

Actual Result:
As expected.

Bad Input:
Test 1: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost -5 (Client)

Expected Result: -1

Actual Result:
As expected.

Test 2: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 0 (Client)

Expected Result: -1

Actual Result:
As expected.

Test 3: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost 1 (Client)

Expected Result: 1

Actual Result:
As expected.

Test 4: java -Djava.security.policy=server.policy engine.ComputeEngine (Server)
java -Djava.security.policy=client.policy client.ComputeLargePrime localhost test (Client)

Expected Result: java.lang.NumberFormatException thrown to client.

Actual Result:
As expected.
 */
package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

public class ComputeEngine implements Compute {

    public ComputeEngine() {
        super();
    }

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub =
                (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
