package ConsistentHashing;
/**
consisting hashing is done by creating a pre defined space for every key possible
[0,2^218-1]
now again the problem arises in case of scaling or scale down we need to rehash complete array
to solve this the ring method was approved
we will place every server on ring at random spacing
and every key in btw two server will belongs to next clockwise server
in any case of downsizing or upsizing only key belongs till prev server need to rehash
the intermediate size btw to server can get very small or large and there can be undistributed keys
this was eliminated using server virtual node so instead of s1 --> we have s1_0 s1_2 s1_3 .....
 **/
public class Example_Two {
}
