**cStyle**
```
23,57%    0x0000000112765de8: ;*aaload {reexecute=0 rethrow=0 return_oop=0}
; - java.util.ArrayList::elementData@5 (line 411)
; - java.util.ArrayList::get@11 (line 428)
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::cStyle@20 (line 35)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_cStyle_jmhTest::cStyle_avgt_jmhStub@19 (line 193)

30,39%    0x0000000112765e00: ;*getfield coder {reexecute=0 rethrow=0 return_oop=0}
; - java.lang.String::coder@7 (line 4556)
; - java.lang.String::length@6 (line 1499)
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::cStyle@28 (line 35)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_cStyle_jmhTest::cStyle_avgt_jmhStub@19 (line 193)

27,83%    0x0000000112765e28: ;*getfield coder {reexecute=0 rethrow=0 return_oop=0}
; - java.lang.String::coder@7 (line 4556)
; - java.lang.String::length@6 (line 1499)
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::cStyle@28 (line 35)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_cStyle_jmhTest::cStyle_avgt_jmhStub@19 (line 193)

5,18%    0x0000000112765e3c: ;*if_icmpge {reexecute=0 rethrow=0 return_oop=0}
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::cStyle@10 (line 34)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_cStyle_jmhTest::cStyle_avgt_jmhStub@19 (line 193)
```

**enhancedForLoop**
```
29,09%    0x0000000113e5a748: ;*aaload {reexecute=0 rethrow=0 return_oop=0}
; - java.util.ArrayList$Itr::next@64 (line 975)
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::enhancedForLoop@25 (line 52)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_enhancedForLoop_jmhTest::enhancedForLoop_avgt_jmhStub@19 (line 193)  

23,18%    0x0000000113e5a760: ;*getfield coder {reexecute=0 rethrow=0 return_oop=0}
; - java.lang.String::coder@7 (line 4556)
; - java.lang.String::length@6 (line 1499)
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::enhancedForLoop@38 (line 53)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_enhancedForLoop_jmhTest::enhancedForLoop_avgt_jmhStub@19 (line 193)

17,19%    0x0000000113e5a788: ;*getfield coder {reexecute=0 rethrow=0 return_oop=0}
; - java.lang.String::coder@7 (line 4556)
; - java.lang.String::length@6 (line 1499)
; - com.github.shautvast.benchmarks.loops.LoopBenchmark::enhancedForLoop@38 (line 53)
; - com.github.shautvast.benchmarks.loops.jmh_generated.LoopBenchmark_enhancedForLoop_jmhTest::enhancedForLoop_avgt_jmhStub@19 (line 193)  
```

