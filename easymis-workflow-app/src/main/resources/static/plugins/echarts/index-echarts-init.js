// ============================================================== 
// Gauge chart option
// ============================================================== 
var gaugeChart = echarts.init(document.getElementById('quality-score'));

// specify chart configuration item and data
option = {
	    series : [
	        {
	            name:'业务指标',
	            type:'gauge',
	            center : ['50%', '50%'],    // 默认全局居中
	            radius : [0, '100%'],
	            min: 0,                     // 最小值
	            max: 100,                   // 最大值
	            splitNumber: 5,       // 分割段数，默认为5
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.6, '#ff4500'],[0.8, '#228b22'],[1, '#48b']], 
	                    width: 5
	                }
	            },
	            axisTick: {            // 坐标轴小标记
	                show: true,        // 属性show控制显示与否，默认不显示
	                splitNumber: 1,   // 每份split细分多少段
	                length :10,        // 属性length控制线长
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: 'auto'
	                }
	            },
	            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
	            	 show: false,
	                 formatter: function(v){
	                     switch (v+''){
	                         case '60': return '及格';
	                         case '80': return '优质';
	                         case '90': return '完美';
	                         default: return '';
	                     }
	                 },
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                	color: '#fff',
	                    fontSize : 15
	                }
	            },
	            splitLine: {           // 分隔线
	                show: true,        // 默认显示，属性show控制显示与否
	                length :5,         // 属性length控制线长
	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
	                    color: '#eee',
	                    width: 2,
	                    type: 'solid'
	                }
	            },
	            pointer : {
	                length : '100%',
	                width : 5,
	                color : 'auto'
	            },
	            title : {
	                show : false,
	                offsetCenter: [0, '-40%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder'
	                }
	            },
	            detail : {
	                show : false,
	                backgroundColor: 'rgba(0,0,0,0)',
	                borderWidth: 0,
	                borderColor: '#ccc',
	                width: 100,
	                height: 40,
	                offsetCenter: ['0%', 0],       // x, y，单位px
	                formatter:'{value}%',
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    color: 'auto',
	                    fontSize : 30
	                }
	            },
	            data:[{value: 50, name: '完成率'}]
	        }
	    ]
};
gaugeChart.setOption(option);// 为echarts对象加载数据

//============================================================== 
//Gauge chart option
//============================================================== 
var qualityRuleChart = echarts.init(document.getElementById('quality-rule'));

//specify chart configuration item and data
option = {
		 title : {
			    show : false,
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
		        x:'right'
		    },
		    tooltip : {
		    	show : false,
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        show : false,
		        orient : 'vertical',
		        x : 'left',
		        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : false,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '100%',
		            center: ['50%', '50%'],
		            data:[
		                {value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}
		            ],
	                itemStyle: {
	                    normal:{
	                        label : {
	                            show : false
	                        },
	                        labelLine : {
	                            show : false
	                        }
	                    }
	                },
		        }
		    ]
};
qualityRuleChart.setOption(option);// 为echarts对象加载数据
//============================================================== 
//Gauge chart option
//============================================================== 
var catalogStatisticsChart = echarts.init(document.getElementById('catalog-statistics'));

//specify chart configuration item and data
option = {
		 title : {
			    show : false,
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
		        x:'right'
		    },
		    tooltip : {
		    	show : false,
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        show : false,
		        orient : 'vertical',
		        x : 'left',
		        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : false,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '100%',
		            center: ['50%', '50%'],
		            data:[
		                {value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}
		            ],
	                itemStyle: {
	                    normal:{
	                        label : {
	                            show : false
	                        },
	                        labelLine : {
	                            show : false
	                        }
	                    }
	                },
		        }
		    ]
};
catalogStatisticsChart.setOption(option);// 为echarts对象加载数据
//============================================================== 
//Gauge chart option
//============================================================== 
var genreStatisticsChart = echarts.init(document.getElementById('genre-statistics'));

//specify chart configuration item and data
option = {
		 title : {
			    show : false,
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
		        x:'right'
		    },
		    tooltip : {
		    	show : false,
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        show : false,
		        orient : 'vertical',
		        x : 'left',
		        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : false,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '100%',
		            center: ['50%', '50%'],
		            data:[
		                {value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}
		            ],
	                itemStyle: {
	                    normal:{
	                        label : {
	                            show : false
	                        },
	                        labelLine : {
	                            show : false
	                        }
	                    }
	                },
		        }
		    ]
};
genreStatisticsChart.setOption(option);// 为echarts对象加载数据

//============================================================== 
//Gauge chart option
//============================================================== 
var monitorTaskChart = echarts.init(document.getElementById('monitor-task'));

//specify chart configuration item and data
option = {
		 title : {
			    show : false,
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
		        x:'right'
		    },
		    tooltip : {
		    	show : false,
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        show : false,
		        orient : 'vertical',
		        x : 'left',
		        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : false,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '100%',
		            center: ['50%', '50%'],
		            data:[
		                {value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}
		            ],
	                itemStyle: {
	                    normal:{
	                        label : {
	                            show : false
	                        },
	                        labelLine : {
	                            show : false
	                        }
	                    }
	                },
		        }
		    ]
};
monitorTaskChart.setOption(option);// 为echarts对象加载数据

//============================================================== 
//Gauge chart option
//============================================================== 
var systemStatisticsChart = echarts.init(document.getElementById('system-statistics'));

//specify chart configuration item and data
option = {
		   tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['周一','周二','周三','周四','周五','周六','周日']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'邮件营销',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'联盟广告',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'视频广告',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'直接访问',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390, 330, 320]
		        },
		        {
		            name:'搜索引擎',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320]
		        }
		    ]
};
systemStatisticsChart.setOption(option);// 为echarts对象加载数据




//============================================================== 
//Gauge chart option
//============================================================== 
var departmentStatisticsChart = echarts.init(document.getElementById('department-statistics'));

//specify chart configuration item and data
option = {
		 title : {
			    show : false,
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
		        x:'right'
		    },
		    tooltip : {
		    	show : false,
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        show : true,
		        orient : 'vertical',
		        x : 'right',
		        y : 'bottom',
		        data:['研发一部','研发二部','研发三部','研发四部','研发五部']
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : false,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '80%',
		            center: ['50%', '50%'],
		            data:[
		                {value:335, name:'研发一部'},
		                {value:310, name:'研发二部'},
		                {value:234, name:'研发三部'},
		                {value:135, name:'研发四部'},
		                {value:1548, name:'研发五部'}
		            ],
	                itemStyle: {
	                    normal:{
	                        label : {
	                            show : false
	                        },
	                        labelLine : {
	                            show : false
	                        }
	                    }
	                },
		        }
		    ]
};
departmentStatisticsChart.setOption(option);// 为echarts对象加载数据






