# FileProducerConsumer-POC

A POC to implement a producer consumer model for File processor using Linked BlockingQueue

**ProducerConsumerController** -> Initialises the 1 producer and 5 fixed size consumer threads in a pool

**FileProducer** -> starts with fixed number of files initially. After iniitialisation, produces 1 file every 2 seconds on the file queue.

**FileProcessor** -> processes the file from the file queue

