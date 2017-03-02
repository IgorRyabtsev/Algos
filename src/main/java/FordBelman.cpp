#include <vector>
#include <set> 
#include <fstream>
using namespace std;

const int INF = 30000;

struct edge {
	int a, b, cost;
};
 
int n, m, v;
vector<edge> e;


int main() {
	
	ifstream in("input.txt");
	ofstream out("output.txt");	
 
	in >> n; 
	in  >> m;
	v=0;
	
	for (int i=0; i<m; i++) {
		int a,b,c;
		edge newedge;
		in >> newedge.a >> newedge.b >> newedge.cost ;
		newedge.a--;
		newedge.b--;

		e.push_back(newedge);
	}

	
	vector<int> d (n, INF);
	d[v] = 0;
	vector<int> p (n, -1);
	for (;;) {
		bool any = false;
		for (int j=0; j<m; ++j)
			if (d[e[j].a] < INF)
				if (d[e[j].b] > d[e[j].a] + e[j].cost) {
					d[e[j].b] = d[e[j].a] + e[j].cost;
					p[e[j].b] = e[j].a;
					any = true;
				}
		if (!any)  break;
	}
 

	// восстановлене путей	
/*
	int t=2;
	if (d[t] == INF)
		out << "No path from " << v << " to " << t << "." << endl;
	else {
		vector<int> path;
		for (int cur=t; cur!=-1; cur=p[cur])
			path.push_back (cur);
		//reverse (path.begin(), path.end());
 
		out << "Path from " << v << " to " << t << ": " << endl;
		for (size_t i=0; i<path.size(); ++i)
			out << path[i] << ' ';
	}
		out << endl;
*/

	for (int i=0; i<n; ++i){
		out  << d[i] << " ";	
	}
}


