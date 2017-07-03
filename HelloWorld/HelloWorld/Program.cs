using System;
using System.Collections.Generic;
using System.Linq;

namespace HelloWorld
{
    class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine ("Hello Mono World");
            
            int[] numbers = new int[] { 97, 92, 81, 60, 69, 12, 95, 15 };

            IEnumerable<int> firstList = numbers.Where(y => y % 2 == 0);
            
            foreach (int e in firstList)
            {
                Console.WriteLine(e);
            }
            
            double averageOfOddNumbers = numbers.Where(y => y % 2 == 1).Average();
            
            Console.WriteLine("average of odd numbers: " + averageOfOddNumbers);
            
            IEnumerable<int> thirdList = numbers.Where(y => y > 0);
            
            foreach (int e in thirdList)
            {
                Console.WriteLine(e * e);
            }
        }
    }
}