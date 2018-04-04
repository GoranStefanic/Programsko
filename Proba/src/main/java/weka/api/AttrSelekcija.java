package weka.api;
//import required classes
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;

public class AttrSelekcija{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb1.arff");
		Instances dataset = source.getDataSet();
		//create AttributeSelection object
		AttributeSelection filter = new AttributeSelection();
		//create evaluator and search algorithm objects
		CfsSubsetEval eval = new CfsSubsetEval();
		GreedyStepwise search = new GreedyStepwise();
		//set the algorithm to search backward
		search.setSearchBackwards(true);
		//set the filter to use the evaluator and search algorithm
		filter.setEvaluator(eval);
		filter.setSearch(search);
		//specify the dataset
	
		filter.setInputFormat(dataset);
		//apply
		Instances newData = Filter.useFilter(dataset, filter);
		//save
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb3.arff"));
		saver.writeBatch();
	}
}